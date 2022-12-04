pipeline {
    agent any
    parameters {
         string(name: 'RunnerFile', defaultValue: 'testng.xml', description: 'Enter your runner file (e.g. testng.xml)')
    }

    stages {
        stage('Build') {
            steps {
                echo 'clone the framework from git repository URL'
                git 'https://github.com/ahmedmostaffa/Nagwa-Automation-Task.git'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn clean test -DfileName=%RunnerFile%'
            }
        }
        stage('Generating html report'){
            steps{
                always{
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'test-output/SparkReport', reportFiles: 'Index.html', reportName: 'HTML Report', reportTitles: ''])

                    }
                }
            }
        }
    }