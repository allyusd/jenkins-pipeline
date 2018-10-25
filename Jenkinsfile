pipeline {
    agent none
    stages {
        stage('parallel') {
            agent {
                docker {
                    label 'docker'
                    image 'maven:3-alpine'
                }
            }
            steps {
                script {
                    def tests = [:]
                    for (f in findFiles(glob: 'image_*')) {
                        def f_inside = "${f}"
                        tests["${f}"] = {
                            node('build') {
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
