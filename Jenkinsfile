pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                label 'cpp'
            }
            steps {
                echo 'Building..'
                git branch: 'gtest', url: 'https://github.com/allyusd/helloworld.cpp.git'
                sh 'g++ helloworld.cpp -o helloworld'
                sh 'g++ unittest.cpp -o unittest -Igtest/include -Lgtest/lib -lgtest -lpthread'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'helloworld', 'unittest'
                }
            }
        }
        stage('Test') {
            agent {
                label 'test'
            }
            steps {
                echo 'Testing..'
                sh '''#!/bin/bash
                curl -O ${BUILD_URL}artifact/helloworld
                chmod +x helloworld
                ./helloworld
                '''
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
