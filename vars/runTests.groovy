def call() {
    sh '''
    poetry run coverage run -m pytest || true
    poetry run coverage report
    poetry run coverage xml -o coverage.xml
    poetry run coverage html
    '''
}
