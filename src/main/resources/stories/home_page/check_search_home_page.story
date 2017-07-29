Narrative:
As a user
I want to perform search request
So that I can achieve opening page with searching result which include list of goods

Scenario: looking up to search items
Given the user is on the rozetka home page
When the user looks up the item 'macbook'
Then they should see search result page with correct items title 'macbook'