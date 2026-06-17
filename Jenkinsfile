pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/nafanjum2004-hash/Ansible-Project.git'
            }
        }

        stage('Build') {
            steps {
                dir('application') {
                    sh 'mvn clean package'
                }
            }
        }
    }
}