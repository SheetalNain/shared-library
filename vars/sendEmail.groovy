def call(String recipient) {
    emailext (
        subject: "Code Coverage Report - Attendance API",
        body: """<p>Hi Team,</p>
                 <p>The latest code coverage report is available. Please find the attached report.</p>
                 <p>You can also access it at: <a href="$BUILD_URL/artifact/htmlcov/index.html">Coverage Report</a></p>
                 <p>Regards,<br>Jenkins</p>""",
        mimeType: 'text/html',
        attachmentsPattern: 'htmlcov/index.html',
        to: recipient
    )
}
