# continuing_ed_tracking
Continuing Education Tracking System

Developed as a Software Engineering course (CS444) project while concurrently learning the Unified Process and UML.

The Continuing Education Tracking System (CETS) is designed to integrate the tracking of continuing education courses for licensed professionals who must satisfy Continuing Education Unit requirements for periodic license renewals. Continuing education courses are provided by myriad vendors and in various formats that include webinars, online multi-media modules, seated courses, seminars, etc. Given the variety of education sources and formats, it can be difficult for license-holders to track these courses and their education credits (and/or hours) during the long periods between license renewals. That's where CETS comes in.

CETS allows users to create a password protected account for their specific license and maintaing a list of completed courses. As courses are entered, a cumulative hour total is calculated and presented in the user account's main screen. Courses can easily be reviewed, added, edited, and if needed, deleted from the list.

But why track education courses and hours if a license does not require submission of this material to the licensing authority for renewal? Because the control mechanism for compliance with education requirements is state or federal audits. If a license-holder cannot compile and present their education history on demand, their license (and livelihood) is in jeapordy.

CETS addresses this issue with an additional feature that allows a user to create a formatted text file report of the user's profile and completed courses. This report is a very useful guide for ensuring all education completed is represented when a user is gathering all of the information required by the education audit.

Development:

This project was developed in Apache NetBeans IDE 11.2. Presentation classes are Java AWT/Swing objects. As persistence was NOT a part of the original requirements for the coursework, CETS only uses an unencrypted text file to save account and course list data. This was mostly for the sake of convenience during testing, as it was a laborious task to re-create accounts over and over whenever the code was changed and re-run. In later versions I plan to implement a proper database.

In reality, I feel this would be better implemented as a mobile application, which may be where I end up taking this. Still, the experience of creating this project using UP and UML was extremely valuable, and I plan to continue to tinker with it as a way to experiment with new approaches to common concerns in the areas of User Interface, Design, Data Structures, Debugging, etc.
