pipeline {
    agent none
    stages {
        stage('parallel') {
            agent {
                docker {
                    label 'docker'
                    image 'ubuntu:18.04'
                }
            }
            steps {
                script {
                    def tests = [:]
                    def abcs = ['maven:3-alpine', 'ubuntu:18.04', 'base/archlinux']
                    for (f in abcs)
                    //for (f in findFiles(glob: 'image_*')) {
                        def f_inside = "${f}"
                        tests["${f}"] = {
                            node('docker') {
                                stage("${f_inside}") {
                                    sh "echo ${f_inside}"
                                    sh 'cat /etc/*-release'
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
