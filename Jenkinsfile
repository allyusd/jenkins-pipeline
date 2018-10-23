pipeline {
    agent none
    stages {
        stage('alpine') {
            agent { docker 'maven:3-alpine' }
            steps {
                sh 'cat /etc/*-release'
            }
        }
        stage('ubuntu') {
            agent { docker 'ubuntu:18.04' }
            steps {
                sh 'cat /etc/*-release'
            }
        }
        stage('archlinux') {
            agent { docker 'base/archlinux' }
            steps {
                sh 'cat /etc/*-release'
            }
        }
    }
}
