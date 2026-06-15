pipeline {
    agent any

    tools {
        jdk 'JDK'
        maven 'Maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Himanshu0320/Capstone-Project'
            }
        }

        stage('Clean Project') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Compile Project') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('Execute TestNG Tests') {
            steps {
                bat 'mvn test -DexecutionMode=jenkins'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'test-output/**/*.*', allowEmptyArchive: true
                archiveArtifacts artifacts: 'Screenshots/**/*.*', allowEmptyArchive: true
                archiveArtifacts artifacts: 'Reports/**/*.*', allowEmptyArchive: true
            }
        }
    }

    post {
        success {
            echo 'BlazeDemo Automation Build Successful'
        }

        failure {
            echo 'BlazeDemo Automation Build Failed'
        }

        always {
            echo 'Pipeline Execution Completed'
        }
    }
}