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
    stage('Deploy Docker') {
        steps {
            dir('application') {
                sh '''
                sudo docker rm -f employee-app || true
                sudo docker build -t employee-management-app .
                sudo docker run -d \
                -p 9090:9090 \
                --name employee-app \
                employee-management-app
                '''
            }
        }
    }


    stage('Health Check') {
        steps {
            sh '''
            sleep 20
            curl http://localhost:9090/health
            '''
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
