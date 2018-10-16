pipeline {
    agent {
        label 'cpp'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                git 'https://github.com/allyusd/helloworld.cpp.git'
                sh 'g++ helloworld.cpp -o helloworld'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh './helloworld'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
