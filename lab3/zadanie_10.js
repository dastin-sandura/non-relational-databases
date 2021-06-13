let removedEmail = db.people.updateMany(
    {job: "Editor"},
    {$unset: 
		{email: ""}
	}
 );

printjsononeline(removedEmail)