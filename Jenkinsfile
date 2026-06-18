pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

    stage('Build') {
        steps {
            dir('application') {
                sh 'mvn clean package'
            }
        }
    }

    stage('Deploy') {
        steps {
            dir('ansible') {
                sh '''
                ANSIBLE_CONFIG=./ansible.cfg ansible-playbook \
                -i inventories/dev/hosts \
                playbooks/deploy.yml
                '''
            }
        }
    }

    stage('Health Check') {
        steps {
            sh 'curl http://localhost:8080/health'
        }
    }
}

    post {
        success {
            echo 'Build and Deployment Successful'
        }

        failure {
            echo 'Build or Deployment Failed'
        }
    }
}