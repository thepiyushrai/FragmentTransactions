# FragmentTransactions
Adding and managing fragments in code
Simply adding a fragment to an activity via the activity's XML layout file sacrifices the activity and cannot remove the fragment at runtime. To have full dynamic control over your fragment at runtime, you need to add these activities to your code. This has the advantage that fragments can be dynamically added, 
removed and even exchanged with each other while the application is running.
Even if you use code to manage your fragments, the fragments themselves consist of layout XML files and corresponding classes. The difference comes when working with fragments within a hosting activity. These steps are being followed when adding fragments to an activity using code.

 1. Create an instance of the fragment's class.
2. Pass additional intent arguments to the class.
3. Get a reference to the fragment manager instance.
4. Call the beginTransaction() method on the fragment manager instance. This returns a fragment transaction instance.
Five. Call the add() method of the fragment transaction instance, passing the resource ID of the view containing the fragment and fragment class instance as arguments.
6. Call the commit() method of the fragment transaction.

This Reposetory explains how  multiple type of transaction operations occurs while navigating to and fro in Activities and Fragments.
