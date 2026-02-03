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
                echo "your working dir is: $PWD"
                ls -la
                '''
            }
        }
        stage('Test') {
            agent {
                docker {
                    image 'node:18-alpine'
                    reuseNode true
                    }
                }
            steps {
                sh '''
                test -f build/index.html
                npm test
                '''
            }

        }
        stage('E2E') {
            agent {
                docker {
                    image 'mcr.microsoft.com/playwright:v1.58.0-noble'
                    reuseNode true
                    }
                }
            steps {
                sh '''
                    npm install -g serve
                    serve -s build
                    npc playwrite test
                '''
            }

        }
    }
}