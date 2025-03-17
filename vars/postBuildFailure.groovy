def call(String emailRecipient) {
    echo "Sending failure notifications..."
    
    emailext body: """Hello,

     The Jenkins build has failed due to missing commit sign-offs.

Job Details:
- Job Name: ${env.JOB_NAME}  
- Build Number: ${env.BUILD_NUMBER}  
- Build URL: ${env.BUILD_URL}  

Regards,  
Jenkins CI
""", 
            subject: "Job Name: ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}", 
            to: emailRecipient
}

