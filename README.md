<h3>Introduction</h3>

When a new pandemic hits, diagnosing individuals is challenging. Testing on a large scale is difficult and tests are likely to be expensive, especially in the beginning. Anyone who has any symptoms of COVID-19 is likely to be very concerned that they have contracted the disease, even if the same symptoms are indicative of many other, potentially milder diseases too.

Instead of taking medical samples from each patient and waiting for slow, expensive lab reports to come back, a simpler, faster, and cheaper test (even if it’s less accurate) would be useful in gathering data on a larger scale. This data will be taken and given to the Machine Learning model which will identifiy the person is suffering from covid 19 or not. 

The information will be shared with the nearby health organization also the users who are nearby to the victim will be informed by using msg. The system will monitor the person who is Corona positive and the person who have came in contact with patient. It is useful in pandemic but when it's over it can also be very useful for other sort of spreading diseases in future. After pandemic when it's all back to normal there lies actual problem for tracking patient at that point out system can be useful.


<h4><strong>Note</strong>:-The entire project is been divided into two parts one part is an <strong>Android Application</strong> and another part is <strong>web application</strong></h4>

<strong><h4>Objective</h4></strong>
<ul>
  <li>To identify remotely whether user is suffering from corona virus or not.</li>
  <li>To monitor active patients or any future patient who are currently in quarantine.</li>
  <li>To get information about whether person came in contact with any patient.</li>
  <li>To give early treatment ASAP (As Soon As Possible).</li>
<li>To provide the current condition of the person suffering from corona virus to the nearby health organization and the nearby users. </li>
  </ul>

<strong><h4>Implementation Diagram</h4></strong>
![dia](https://user-images.githubusercontent.com/32026402/83355946-4bbc6280-a380-11ea-8d63-7e53d87db28f.png)	
<ul>
  <li>Our system will accept the information from the user like Symptom, Location of user.</li>
<li>This information will be stored into the database.</li>
<li>The information will be given to the machine learning model to identify whether user is suffering from corona virus or not. It predicts this using symptom provided by user along with whether users come in contact with any active patient.</li>
  <li>If the user seems to be Corona positive then system will monitor active patients or any future patient who are currently in quarantine. System can also be used to monitor using live location of patient.</li>
<li>If there is any patient present in city patient area is given to all users present in that area so they can stay alert.</li>
<li>If user came in contact with host of COVID-19 then our system gives information to user as well as nearby facilities. To give early treatment ASAP.</li>
</ul>

<strong>Installation Process</strong>
<ul>
  <li>Open Android Studio</li>
  <li>Clone this repository in android studio</li>
  <li>Connect project to <a href="https://console.firebase.google.com/">Firebase</a></li>
  <li>Activet Firebase authentication for email and mobile</li>
  <li>Active realtime database of firebase and change it permission rule to "read:true" and "write:true"</li>
  <li>Go to <a href="https://console.developers.google.com/">Google API Console</a></li>
  <li>Activate Map and Nearby Functionaly for genrated API</li>
  <li>Copy that api into app</li>
  <li>You are good to go</li>
 </ul>

<a href="https://github.com/sharmatanesh/Anti-Pandemic-System-Doctor">Click Here to Go on Part 2</a>
