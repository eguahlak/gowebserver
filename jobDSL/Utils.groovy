static def configureGit(def job, def repositoryUrl) {
    job.with {
        scm {
            git {
                remote {
                    name('origin')
                    url(repositoryUrl)
					credentials('1d5b1f18-2a96-4fab-9a9d-3597ee4b3241')
                }
                branch('*/ready/**')
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