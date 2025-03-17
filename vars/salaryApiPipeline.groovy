def call(String gitUrl, String branchName) {
    pipeline {
        agent any
        tools {
            maven 'Maven'
        }

        stages {
            stage('Clone Repo') {
                steps {
                    git branch: branchName, url: gitUrl
                }
            }

            stage('Dependency Scan') {
                steps {
                    sh '''
                        mvn org.owasp:dependency-check-maven:check -Dformat=HTML -DoutputDirectory=target
                        echo "Dependency check report generated"
                    '''
                }
            }
        }
    }
}
