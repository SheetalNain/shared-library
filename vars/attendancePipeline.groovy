def call(Map config = [:]) {
    pipeline {
        agent any

        environment {
            POETRY_HOME = "$WORKSPACE/.poetry"
            PATH = "$POETRY_HOME/bin:$PATH"
        }

        stages {
            stage('Clone Repository') {
                steps {
                    script {
                        cloneRepo(config.repoUrl, config.branch)
                    }
                }
            }

            stage('Install System Dependencies') {
                steps {
                    script {
                        installDependencies()
                    }
                }
            }

            stage('Install Poetry & Dependencies') {
                steps {
                    script {
                        installPoetry()
                    }
                }
            }

            stage('Run Tests & Generate Coverage Report') {
                steps {
                    script {
                        runTests()
                    }
                }
                post {
                    always {
                        archiveArtifacts artifacts: 'htmlcov/**/*', fingerprint: true
                        sendEmail(config.email)
                    }
                }
            }
        }
    }
}
