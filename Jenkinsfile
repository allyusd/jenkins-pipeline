pipeline {
    agent none
    stages {
        stage('parallel') {
            parallel {
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
                            image 'ubuntu:18.04'
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
                            image 'base/archlinux'
                        }
                    }
                    steps {
                        sh 'cat /etc/*-release'
                    }
                }
            }
        }
    }
}
