resource "aws_ecs_task_definition" "inventory_service" {
  family                   = "inventory-service"
  network_mode             = "awsvpc"
  requires_compatibilities = ["FARGATE"]
  cpu                      = "512"
  memory                   = "1024"
  execution_role_arn       = var.ecs_execution_role_arn
  task_role_arn            = var.ecs_task_role_arn

  container_definitions = jsonencode([
    {
      name      = "inventory-service"
      image     = "${var.ecr_registry}/inventory-service:latest"
      portMappings = [
        {
          containerPort = 8083
          protocol      = "tcp"
        }
      ]
      environment = [
        { name = "DB_HOST", value = var.db_host },
        { name = "DB_JDBC_URL", value = var.db_jdbc_url },
        { name = "DB_PASSWORD", value = var.db_password },
        { name = "DB_USERNAME", value = var.db_username },
        { name = "JWT_SECRET", value = var.jwt_secret }
      ]
      logConfiguration = {
        logDriver = "awslogs"
        options = {
          awslogs-group         = "/ecs/inventory-service"
          awslogs-region        = "us-east-1"
          awslogs-stream-prefix = "ecs"
        }
      }
    }
  ])
}

resource "aws_ecs_service" "inventory_service" {
  name            = "inventory-service"
  cluster         = "arka-ecs-cluster"
  task_definition = aws_ecs_task_definition.inventory_service.arn
  desired_count   = 1
  launch_type     = "FARGATE"

  network_configuration {
    subnets          = ["subnet-057a322f484b9f962", "subnet-09ee219f4838cb06f"]
    security_groups  = [var.security_group_id]
    assign_public_ip = false
  }

  load_balancer {
    target_group_arn = var.target_group_arn
    container_name   = "inventory-service"
    container_port   = 8083
  }

  depends_on = [aws_ecs_task_definition.inventory_service]
}

resource "aws_cloudwatch_log_group" "inventory_service" {
  name              = "/ecs/inventory-service"
  retention_in_days = 14
}

variable "ecr_registry" { default = "dummy" }
variable "db_host" { default = "dummy" }
variable "db_jdbc_url" { default = "dummy" }
variable "db_password" { default = "dummy" }
variable "db_username" { default = "dummy" }
variable "jwt_secret" { default = "dummy" }
variable "security_group_id" { default = "sg-00000000" }
variable "target_group_arn" { default = "arn:aws:elasticloadbalancing:us-east-1:000000000000:targetgroup/dummy/0000000000000000" }
variable "ecs_execution_role_arn" { default = "arn:aws:iam::148761677807:role/arka-task-execution-role" }
variable "ecs_task_role_arn" { default = "arn:aws:iam::000000000000:role/dummy" }
