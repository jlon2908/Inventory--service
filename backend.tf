terraform {
  backend "s3" {
    bucket = "arka-dev-artifacts"
    key    = "inventory-service/terraform.tfstate"
    region = "us-east-1"
    encrypt = true
  }
}
