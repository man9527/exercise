package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BehaviorQuestions {

    List<String> qs = Arrays.asList(
            // 1. Customer
            "An example you used customer feedback to drive improve and innovation",
            "most difficult customer interaction",
            "customer want one thing but you felt they needed something else",
            "An example you went above and beyond the call of duty",
            "an example you feel frustrated or impatient with a customer",
            "see around the corner to meet a customer need or delight them",
            "over commit",
            "balance customer need or need of the business",
            "how to evaluate quality of product",
            "changes you made to current department to meet the needs of your customers",

            // 2. Ownership
            "took on something significant outside your area of responsibility",
            "An example when you didn't think you were going to meet the commitment",
            "Hard decision to sacrifice short term gain for a longer term goal",
            "help a peer",
            "project transitioned",
            "team stays connected to company vision",
            "untertook initiative that could benefit the whole company or customers",

            // 3. Invent and Simplify
            "Revolutionary vs Evolutionary",
            "resolve complex problem with simple solution",
            "make something significantly simpler for customers",
            "Challenging problem or situation which usual approach won't work. What alternative approach",
            "Creative idea but difficult to implement",
            "out of box idea that had big impact on your business",
            "change the direction or view of a specific department and embrace a new way of thinking",
            "how to draw out new thinking and innovation out of your team",
            "enable your team or a team member to implement a significant change or improvement",

            // 4. Are Right A Lot
            "a decision for which data and analysis weren't sufficient and must rely on judgement and instinct",
            "made a difficult decision and how you know it's a right decision",
            "A bad decision and learning from the experience",
            "when you have multiple solution, how did you decide",
            "an error in judgement you made in the last two years",
            "business model or key technical decision",
            "top strategic issue to face",

            // 5. Hire and develop the best
            "best hires of your career. How did this person progress. How did you identify this person during hiring",
            "help your team to develop their careers. three examples you invested",
            "your hiring process when hiring key position",
            "low performer. how did you deliver feedback",
            "hiring someone you thought was better than you in a number of areas",
            "how do you motivate your team",
            "how do you measure performance",

            // 6. Bias for Action
            "example of a calculated risk",
            "made an important business decision without consulting your manager",
            "works against deadline and didn't have to consider all options",
            "what did you do when you felt your team was not moving enough",
            "remove a serious roadblock / barrier preventing your team from progressing",

            // 7. Think Big
            "Radical approach to a problem",
            "How do you drive adoption for your vision/ideas",
/**/        "an example about an initiative or goals and saw opportunity to do much bigger",
            "a key process was working well but still right one? result?",
            "took big risk??",
            "took big risk but failed",
            "you came up with the vision for a team? how do you gain buy-in and drive execution",
            "encouraging member to take big risk",
            "had to develop a product/business model??",

            // 8. insist on the highest standards
            "unsatisfied with status quo and how do you change it",
            "an example you wouldn't compromise on achieving a great outcome",
            "measure you put in place to ensure performance improvement are achieved",
            "significant continuous improvement projects",
            "a goal you have had where you wish you had done better",
            "improved a product when it's already very good",
            "how do you seek out feedback for your team's performance",
            "a team member not productive",
            "the process you go through to set specific target to improve critical area",

            // 9. Earn Trust
            "you significantly contributed to improving morale and productivity. what's the problem and how to prevent",
            "three things you are working on to improve your overall effectiveness",
            "Example tough or critical piece feedback and what did you do",
            "idea you had was strongly opposed. why. how did you handle?",
            "significant professional failure. why, what did you learn",
            "not able to meet a commitment to a team member. what is it and what prevent you",
            "How do you build the trust relationship on your team",
            "when you needed the cooperation of a peer who was resistant. What did you do and outcome?",
            "a direct feedback you gave to colleagues. how they respond. how do you like to receive feedback from others",
            "communicate a big change with a lot of concerns. how you handle questions/resistance.",
            "example of your goals out of alignment with another team. how did you work and did you succeed?",
            "you uncovered a significant problem in your team. what was it and how did you communicate to your manager and peers",

            // 10. Deep Dive
            "example you were trying to understand a problem and you need to go down several layers. who did you talk to and what info is valuable",
            "a problem you had to solve that required in-depth thought and analysis. How do you know you are focusing on the right thing",
            "a time when you linked two or more problems together and identified an underlying issue",
            "an example of a big problem in your org that you helped to solve. how did you become aware of it. were you able to find solution?",
            "A significant metrics you have to used to identify a need for a change. Did you create it or it is already available?",
            "an example you need to ask 5 questions to get the root cause",
            "how do you stay connected to the detail. An example you were too far and failed",
            "your direct reports present a plan or issue. how do you know if the assumption is correct",

            // 11. Have Backbone
            "A time that you strongly disagreed with your manager. What was about it and how did you handle it.",
            "took an unpopular stance in a meeting with peers and leaders. what is it and why. what did you do",
            "decide to go along with the group decision even you disagree",
            "a time where you felt really strongly about something but ultimately lost the argument. how hard did you press. what did you do after you lost",
            "give an example you submitted a good idea to your manager and didn't take action on it. how did you handel it and what was the outcome",
            "the business gained something because you persisted for a length of time. why you so determined and was it a right decision?",
            "an example of a difficult decision under pressuer and then defend and justify. was it a right decision?",
            "an example you had to support a business initiative that you don't agree",
            "an example you pushed back against a decision that negatively impacted your team",

            // 12. Deliver Results
            "a time you were half way to the objective and you know it not be the best and stop",
            "a goal that took a long time and still working towards",
            "an example of not only meeting the goal but exceeds",
            "deliver an important project under a tight schedule",
            "a time you had significant, unanticipated obstacles to overcome in achieving a key goal. were you successful?",
            "How do you ensure you are focusing on the right deliverables when you have several priorities. An example when you drop a ball",
            "secret to success in setting stretch goal yet achievable. a time you didn't hit the right balance. how did you adjust.",
            // https://www.linkedin.com/pulse/inspiring-excellence-through-stretch-goals-inspire-sougat-chatterjee/
            "an example of a mission you didn't think was achievable. what and how you did. success?",

            // 13. Frugality
            "an example how you have helped save costs or eliminate waste in your org",
/**/        "an example to trade off quality and cost. how did you weight the options? what was the result?",
            // https://www.pivotaltracker.com/blog/make-smart-tradeoffs-developing-software-products/
            
            "had to get something done with half or two thirds of resources you thought you'd need for the project or initiative",
            "generated a creative solution to a problem without requiring additional resources",
/**/        "a time you didn't have enough resources to do something important. you found a creative way to get it done",
            "an example of a time you requested additional funding/budget to complete a project",
            "a time when you challenged your team to come up with more efficient solution or process",
            "how do you determine when to award or ask for additional resources and what's the criteria?",
            "how you increased revenue stream or lowering the cost structure",

            // 14. Learn and be curious
            "coolest thing you have learned",
            "a time when you realized you need a deeper level of knowledge",
            "work outside of your comfort zone and found it rewarding",
            "a time you didn't what to do next or how to solve a challenging problem",
            "an example you pushed the existing boundaries",
            "how have you kept up to date with market and competitor trends",
            "you challenge an old way",
            "you realized your team not as effective as expect",
            "a team member challenged you to think differently",
            "unable to achieve a goal but learned",
            "a time a member of your team contributed significantly to a project outside of their role"
                                   );


    public static void main(String[] args) {
        Random r = new Random();
        BehaviorQuestions bq = new BehaviorQuestions();
        System.out.println( bq.qs.get(r.nextInt( bq.qs.size())));
    }






}
