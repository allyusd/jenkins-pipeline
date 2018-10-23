pipeline {
    agent none
    stages {
        stage('alpine') {
            agent {
                docker {
                    label 'docker'
                    image 'maven:3-alpine'
                }
            }
            steps {
                sh 'cat /etc/*-release'
            }
        }
        stage('ubuntu') {
            agent {
                docker {
                    label 'docker'
                    image 'maven:3-alpine'
                }
            }
            steps {
                sh 'cat /etc/*-release'
            }
        }
        stage('archlinux') {
            agent {
                docker {
                    label 'docker'
                    image 'maven:3-alpine'
                }
            }
            steps {
                sh 'cat /etc/*-release'
            }
        }
    }
}
