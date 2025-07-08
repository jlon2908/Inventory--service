resource "aws_ecr_repository" "inventory_service" {
  name                 = "inventory-service"
  image_tag_mutability = "MUTABLE"
  image_scanning_configuration {
    scan_on_push = true
  }
}

