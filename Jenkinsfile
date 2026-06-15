pipeline {

    agent any

    tools {
        jdk 'JDK'
        maven 'Maven3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'Paste your github repo link here'
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
                bat 'mvn test'
            }
        }

        stage('Package Project') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Archive Reports') {
            steps {

                archiveArtifacts(
                    artifacts: 'reports/**/*.*',
                    allowEmptyArchive: true
                )

                archiveArtifacts(
                    artifacts: 'screenshots/**/*.*',
                    allowEmptyArchive: true
                )

                archiveArtifacts(
                    artifacts: 'test-output/**/*.*',
                    allowEmptyArchive: true
                )
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