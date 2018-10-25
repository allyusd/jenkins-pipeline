pipeline {
    agent none
    stages {
        stage('parallel') {
            agent {
                label 'test'
            }
            steps {
                script {
                    def tests = [:]
                    def imagelist = ['maven:3-alpine', 'ubuntu:18.04', 'base/archlinux']
                    for (f in imagelist) {
                        def f_inside = "${f}"
                        tests["${f}"] = {
                            node('docker') {
                                stage("${f_inside}") {
                                    docker.image("${f_inside}").inside {
                                        sh "echo ${f_inside}"
                                        sh 'cat /etc/*-release'
                                    }
                                }
                            }
                        }
                    }
                    parallel tests
                }
            }
        }
    }
}
