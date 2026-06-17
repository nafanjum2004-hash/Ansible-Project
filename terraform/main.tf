module "security_group" {
  source = "./modules/security-group"

  security_group_name = var.security_group_name
  allowed_ports       = var.allowed_ports
}

module "ec2" {
  source = "./modules/ec2"

  instance_name    = var.instance_name
  instance_type    = var.instance_type
  key_name         = var.key_name
  security_group_id = module.security_group.security_group_id
}