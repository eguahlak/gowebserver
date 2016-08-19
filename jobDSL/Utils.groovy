static def configureGit(def job, def repositoryUrl) {
    job.with {
        scm {
            git {
                remote {
                    name('origin')
                    url(repositoryUrl)
                }
                branch('master')
            }
        }
        triggers {
            scm('* * * * *')
        }
    }
}

static def configureEnv(def job, def username) {
    job.with {
        properties {
            environmentVariables {
                keepSystemVariables(true)
                keepBuildVariables(true)
                env('GITHUB_USERNAME', username)
            }
        }
    }
}