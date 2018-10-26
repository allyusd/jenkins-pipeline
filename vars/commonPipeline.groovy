def call() {
    pipeline {
        agent none
        stages {
            stage('parallel') {
                agent {
                    label 'test'
                }
                steps {
                    script {
                        def tasks = [:]
                        def imagelist = readFile('imagelist').replace("\n", "").split(',')
                        for (image in imagelist) {
                            def image_inside = "${image}"
                            tasks["${image}"] = {
                                node('docker') {
                                    stage("${image_inside}") {
                                        docker.image("${image_inside}").inside {
                                            sh "echo ${image_inside}"
                                            sh 'cat /etc/*-release'
                                        }
                                    }
                                }
                            }
                        }
                        parallel tasks
                    }
                }
            }
        }
    }
}
