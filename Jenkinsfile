[Forwarded from Oleg]
pipeline {
    agent any

    tools {
        // Install the Maven version configured as "Maven 3" and add it to the path.
        maven "Maven 3"
    }

    parameters {
     gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
    }

  stages {
        stage('Run tests') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://github.com/MaryLakhanich/SauceDemo_Maria_Lakhanich.git'

                // Run Maven on a Unix agent.
               bat "mvn -Dmaven.test.failure.ignore=true clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Generate Allure report') {
            steps {
                 script {
                    allure([
                     includeProperties: false,
                     jdk: '',
                     properties: [],
                     reportBuildPolicy: 'ALWAYS',
                     results: [[path: 'target/allure-results']]
                     ])
                }
            }
        }

    }
}