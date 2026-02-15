pipeline {
    agent any
    
    tools {
            maven 'Maven_3.9.9'
       
    }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'edge'], description: 'Select browser')
        choice(name: 'GROUP', choices: ['smoke', 'regression'], description: 'Select test group')
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/yourusername/PracticingTestNg.git'
            }
        }

        stage('Clean Project') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Run Tests') {
            steps {
                sh "mvn test -Dbrowser=${params.BROWSER} -Dgroups=${params.GROUP}"
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/**', fingerprint: true
            }
        }
    }

    post {

        always {
            echo 'Pipeline execution completed.'
        }

        success {
            echo 'Build SUCCESS'
        }

        failure {
            echo 'Build FAILED'
        }
    }
}
