def call() {
    sh '''
    if ! command -v poetry &> /dev/null; then
        curl -sSL https://install.python-poetry.org | python3 -
        export PATH="$HOME/.local/bin:$PATH"
    fi
    
    poetry --version
    poetry install
    '''
}
