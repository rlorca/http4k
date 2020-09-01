title: http4k blog: A retrospective on http4k v3
description: An overview of the Kotlin "Server as a Function" library, http4k

#  A retrospective on http4k v3.

##### [@daviddenton][github]

It's been quite a long time since we released version 3 of [http4k] all the way back in November 2017. Wow - that's over 1000 days in fact! Still, that doesn't mean that we've been sitting on our hands over in http4k Towers; far from it, we've been busier than ever making sure that we'll remember 2020 for more than just hibernating away in a bunker. In fact it did give us an idea for a pretty original piece of swag... 

<img src="./mask_black.png" alt="mask"/>

The eagle-eyed amongst you may have noticed that the project branding has undergone a bit of cosmetic surgery - we thought we'd treat ourselves to a professional job as opposed to the one I knocked up on the cheap way back at the start of the project. We're planning to do an entire refit of the content over the next few months, hopefully to make everything a little easier to find and to provide a few more pointers about where to start with the library.

Anyway, I digress. We thought that we'd do a bit of a retrospective on what has happened in that time. But first, some numbers about what has gone on in those 1000 days:

```groovy
>2500 commits
268 releases
257 PRs merged
139 issues fixed
71 new amazing contributors
28 new http4k library modules
5 newly supported HTTP client libraries
5 new server engines
4 new messaging format modules
4 new testing integrations
2 new serverless backends 
2 new templating libraries supported
0 new dependencies added to the core module ;)
```

If you'd like to check out the old version in the GitHub time machine, [here](https://github.com/http4k/http4k/tree/6639c964abf43c265591e3f70eb59467e60cd089) is how the code looked all that time ago.

#### Where has it been used?
Neo-bank
Government
Investment banks

#### Chitter chatter 
In 2018, we were lucky enough to be invited to KotlinConf in Amsterdam to talk about the development of [http4k], and this led to us alone presenting at a total of 10 international conferences, meetups and privately hosted company events spanning across 5 timezones to talk about the library and it's development.

, with more to come in the latter part of 2020 and beyond. 

#### Performing to a crowd
One of the most frequent questions that we get asked about http4k is "how does it perform?". We attempted to answer that question by entering our baby into the TechEmpower benchmarks, which is a suite of tests which pits each library against the rest of the pack in a set of real-world-esque scenarios to see how it performs including JSON serialisation, database access and HTML templating generation.

Overall, we were thrilled (and continue to be) with the results of the benchmarks. Since the first round (16), [http4k] has been the best performing pure Kotlin web library across the contenders. The most important factor to us that there were no special tricks involved in the implementations - ie. the endpoints under test were written exactly as they would be on a "real" project and no custom tuning other than standard JVM options applied.

In terms of the performance of the server backends, Apache HttpComponents (version 4) has been consistently the strongest performer in the previous benchmarks, although there have been performance improvements to the Netty backend implementations that we are hopeful in the upcoming round 20 might make it a real contender for the http4k 👑.

#### On the radar
Another high point for us was having [http4k] featured in the [Thoughtworks Technology Radar], which is a quarterly publication highlighting tools, techniques and languages that the well-known consultancy have been using to successfully deliver projects across the globe. ThoughtWorks called out the test-driven nature of [http4k], citing:

##### *"Apart from its elegance and simplicity, we also like its emphasis on testability — given that the entities in the libraries are immutable and the routes in the app, as well as the app itself, are just functions, they're super easy to test." - TW TechRadar*

#### The platform!
BOM

#### Cloudy-wowdy stuff
Just as in every codebase there is a package called "utils", this also happens with libraries - useful tools that don't quite fit anywhere else yet you just always end up needing. For [http4k], these utils were about the ancillary stuff that goes around an application to make it support 12-factor ideals such as Environmental configuration and relative primitives. We didn't want to put this stuff into the core module as we felt it wasn't absolutely necessary (and we wanted to continue to keep the binary size of the )

<img src="./lenses.png" alt="lenses"/>

#### Testing modules

#### Community involvement

#### OAuth rollout

#### Versioning 

#### OpenAPI FTW
One of the most popular and standout [http4k] features is the support for the OpenApi specification. Originally supporting Swagger 2 spec via the `http4k-contract` module, we rewrote the implementation to add support for much more complete (and consistent!) version 3 of specification in May 2019. The module will now generate fully compliant OpenAPI3 documentation, including full JSON Schema breakdowns for class models and taking advantage of Kotlin class features such as enums and nullability. Powered by the [http4k] lens API, this runtime system allows developers to avoid concerning themselves with tediously documenting API models which can easily go stale.

#### Serverless turnabout
The major [http4k] feature in version 3.0.0 was the addition of support for Serverless backends - namely the granddaddy of Serverless - AWS Lambda. And you know what they say about the first implementation of something? They say that it's probably wrong. Well, turns out they were right (again). When we got to introducing the second and third implementations of Serverless (Google Cloud Functions and OpenWhisk), we realised that the approach taken for AWS wasn't very dev friendly... it relied on reflection to solve the problem of loading the Lambda function class. This actually broke one of our own cardinal rules that we set for the [http4k] project: 

*Absolutely no magic involved: No reflection. No annotations.*
 
So - we did what any good dev team would do and replaced the magic function loading mechanism with a more developer friendly API working by class extension. Fear not readers - the guilty parties have been appropriately punished, and it (probably) won't happen again. 😉

One other piece of interesting research which came out and somewhat vindicated the dependency-lite approach of [http4k] was [Cold Start War](https://mikhail.io/2018/08/serverless-cold-start-war/), which performed a lot of experiments and concluded that:

##### *"As expected, the dependencies slow the loading down. You should keep your Functions lean, otherwise, you will pay in seconds for every cold start."*

For production deployments, we continue to recommend the use of a tool such as Proguard or R8 to massively reduce the size of packaged Serverless Function JAR file. The [http4k] serverless modules also ship with zero or minimal dependencies to avoid any transitive bloat that might occur.

#### Future

#### CLI

#### Toolbox

#### versioning

#### developer friendly focus



[github]: http://github.com/daviddenton
[http4k]: https://http4k.org
[Slack]: http://slack.kotlinlang.org/
[Thoughtworks Technology Radar]: https://www.thoughtworks.com/radar/languages-and-frameworks/http4k


