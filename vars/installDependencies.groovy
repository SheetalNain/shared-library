def call() {
    sh '''
    sudo apt update
    sudo apt install -y libpq-dev gcc python3-dev python3-venv
    '''
}
