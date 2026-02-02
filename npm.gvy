pipeline {
    agent any

    stages {
        stage('w/o docker') {
            steps {
                sh echo '"Without Docker"'
            }
        }
        stage('w/ docker') {
            agent {
                docker {
                    image: node:18-alpine
                }
                sh echo '"With Docker"'
            }
        }
    }
}