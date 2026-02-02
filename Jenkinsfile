pipeline {
    agent any

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'node:18-alpine'
                    reuseNode true
                    }
                }
            steps {
                sh '''
                echo "Build stage"
                echo "$PWD"
                ls -la
                '''
            }
        }
        stage('Test') {
            steps {
                sh '''
                echo "This is a test"
                ls -l build | grep index
                '''
            }

        }
    }
}