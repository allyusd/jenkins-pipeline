pipeline {
    agent none
    stages {
        stage('Build') {
            agent { docker 'maven:3-alpine' }
            steps {
                sh 'cat /etc/*-release'
            }
        }
        stage('Test') {
            agent { docker 'ubuntu:18.04' }
            steps {
                sh 'cat /etc/*-release'
            }
        }
        stage('Deploy') {
            agent { docker 'base/archlinux' }
            steps {
                sh 'cat /etc/*-release'
            }
        }
    }
}
