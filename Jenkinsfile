pipeline {
agent any

```
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

    stage('Health Check') {
        steps {
            sh 'curl http://localhost:9090/health'
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
```

}
