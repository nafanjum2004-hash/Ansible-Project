variable "aws_region" {
  description = "AWS region"
  type        = string
}

variable "instance_name" {
  description = "EC2 instance name"
  type        = string
}

variable "instance_type" {
  description = "EC2 instance type"
  type        = string
}

variable "key_name" {
  description = "AWS key pair name"
  type        = string
}
variable "security_group_name" {
  description = "Security Group Name"
  type        = string
}

variable "allowed_ports" {
  description = "Allowed Ports"
  type        = list(number)
}