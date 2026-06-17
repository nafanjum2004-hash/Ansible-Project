variable "security_group_name" {
  description = "Security group name"
  type        = string
}

variable "allowed_ports" {
  description = "List of allowed ports"
  type        = list(number)
}