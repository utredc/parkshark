pipeline {
    agent any

    tools {
        jdk 'jdk-12.0.2'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean test-compile'
            }
        }
    }
}
