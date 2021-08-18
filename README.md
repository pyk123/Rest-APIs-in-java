# Rest-APIs-in-java
 This platform would have the following high level entities,
 with following relationship among them. Broadly 
 1 entity should correspond to 1 table in system 1. Question - Core entity of the platform 
 2. Company - A company for which question was asked, Eg: Amazon/Microsoft 
 3. 3. Topic - Topic for which a question was being asked eg: Data Structures, Algorithms a. Subtopic - A topic can have various subtopics. Eg: For topic Data Structures, it can have subtopics like Stacks, Queues, Lists etc.
 4.  4. Answer - A questions can have multiple answers
 5.   5. Answer_comments - Users can comment on answers, hence an answer can have multiple comments 
 6.   6. Question_likes - User have like a question 
 7.   7. Question_company_mapping - A question can be asked for many companies. For example, the same question may be asked by Amazon and Microsoft. To capture this information, we need to have this entity. 
 8.   8. Answer_likes - Users may like an answer to a question. This data would be captured in this table. 
 9.   9. Tags - Not all information can be captured using topics and subtopics. For example while subtopics can be Stacks, Queues and Lists, master list of tags may contain complexities of algorithms which could be O(n), O(logn) etc. 
 10.   10. Question_tags - A Question can be associated with multiple tags. This table will contain that information 
 11.   11. User - User who is posting question/answer/likes etc
