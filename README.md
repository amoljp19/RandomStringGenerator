# Note
After trying different approaches to fetch random string based on length, what I noticed, for every possible try everytime I get 100 length random string.
Due to that I wont go further and stopped here, because, To handle this use case properly I need more information, I tried to reach out to HR regarding few confirmation (is provided apk contentProvider always returns 100 length String or Not), but She didnt pickedup 
call in afternoon, I need selection criteria related more infromation, I mean in exactly what parameter or values we need to use while querying to contentProvider. without knowing those values
going further and trying things I feel waste of my time and efforts. So decided stop working on another use cases further, I hope you understand this situation.

BTW, I followed proper clean + MVVM architecture and latest android developement tech stack along with jetpack compose. even passing dynamic length in query and error handling also done, delete or showing list of string that is not big deal to achieve but due to above 
situation not worked on those usecases. One Deprecated package is present in codebase, that is, initally I built normal contenProvider and tested, does random string comming from provided .apk file or not, that time also 100 lenght random string comming, but later I improved that as per architecture, so earlier MyContentProvider put into that deprecated package.


# Screenshots

![beforeClick](https://github.com/user-attachments/assets/5ddf93e6-6271-4403-aded-b350ee82e6d2)
![randomstringgenerated](https://github.com/user-attachments/assets/f310dea5-48ee-421f-a4df-6a4507964efb)
![onlengthstring](https://github.com/user-attachments/assets/bdc3d2ba-6be7-4118-bcb2-d67ce2808b1a)
![100LengthString](https://github.com/user-attachments/assets/6ed6a135-70dc-42e5-a375-26aa7d63ba1f)








# Refered Links For Developement & Final Conclusion 

https://www.geeksforgeeks.org/content-providers-in-android-with-example/

https://medium.com/androiddevelopers/package-visibility-in-android-11-cc857f221cd9

https://medium.com/@sec.zone64/content-provider-in-android-a9d0450bdeab

https://www.geeksforgeeks.org/how-to-limit-the-number-of-rows-returned-in-sqlite/

https://medium.com/p/8656e0042b10

https://jossypaul.medium.com/loading-data-from-contentprovider-using-coroutines-and-livedata-34aa5e79b8ba

https://medium.com/@anteprocess/android-compose-create-a-simple-mvvm-project-with-basic-four-layers-776b586d00af

https://developer.android.com/kotlin/coroutines

https://developer.android.com/training/dependency-injection/hilt-android

https://medium.com/@kursatkumsuz/how-to-inject-coroutine-dispatchers-using-hilt-39d99a33824b#:~:text=Let's%20create%20a%20module%20for%20this.&text=After%20creating%20our%20module%2C%20we,qualifier%20for%20each%20coroutine%20dispatcher.&text=Now%20we%20can%20inject%20a%20coroutine%20dispatcher%20into%20our%20class.&text=As%20you%20can%20see%2C%20not,more%20testable%20and%20flexible%20code.

https://stackoverflow.com/questions/69724932/jetpack-compose-navigation-with-hiltviewmodel-mainactivity-does-not-implement-i

https://www.geeksforgeeks.org/fetch-text-from-editable-textfield-in-android-jetpack-compose/

https://b-chandrasaimohan.medium.com/content-providers-for-interview-2124d09c096c

https://stackoverflow.com/questions/10390577/limiting-number-of-rows-in-a-contentresolver-query-function

https://stackoverflow.com/questions/2810615/how-to-retrieve-data-from-cursor-class

https://stackoverflow.com/questions/26901644/meaning-of-android-content-urimatcher

https://medium.com/@zekromvishwa56789/understanding-contentprovider-and-contentresolver-in-android-with-kotlin-f31952062649

https://hackajob.com/talent/blog/best-content-providers-for-android
