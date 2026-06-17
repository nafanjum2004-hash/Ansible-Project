pipeline {
    agent any

    tools {
        maven 'Maven'
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