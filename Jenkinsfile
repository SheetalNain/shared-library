@Library ('commit-signoff@main') _

pipeline {
    agent any
    
    
    
    stages{
        stage('clean-workspace') {
            steps{
                script {
                cleanWorkspace()
                }
            }
        }
        
        stage('git clone') {
            steps{
                
                gitClone( '' , 'main'  )
                
            }
        }
        
        stage('Commit signoff') {
                steps {
                    verifyCommitSignOff()
                }
            }
            
            
    }
    
    post {
        
        success {
            postBuildSuccess("sheetal.nain@mygurukulam.co")
            }
            
            failure {
                postBuildFailure("sheetal.nain@mygurukulam.co")
            }
        
    }
}
