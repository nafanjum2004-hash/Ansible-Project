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