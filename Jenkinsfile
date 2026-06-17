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
    }
}