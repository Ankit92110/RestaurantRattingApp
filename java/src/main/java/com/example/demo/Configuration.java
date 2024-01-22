package com.example.demo;

import com.example.demo.commands.AddRatingCommand;
import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.DescribeRestaurantCommand;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.GetReviewFileterOrderCommand;
import com.example.demo.commands.GetReviewsCommand;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.commands.ListRestaurantCommand;
import com.example.demo.commands.RegisterRestaurantCommand;
import com.example.demo.commands.RegisterUserCommand;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.repositories.IRestaurantReposiotry;
import com.example.demo.repositories.IReviewReposiotry;
import com.example.demo.repositories.IUserReposiory;
import com.example.demo.repositories.RestaurantRepository;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.repositories.UserRepsitory;
import com.example.demo.services.GreetingService;
import com.example.demo.services.IRestaurantService;
import com.example.demo.services.RestaurantService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final IGreetingRepository greetingRepository = new GreetingRepository();
            private final IRestaurantReposiotry restaurantReposiotry=new RestaurantRepository();
            private final IUserReposiory userReposiory=new UserRepsitory();
            private final IReviewReposiotry reviewReposiotry=new ReviewRepository();
    
            // Initialize services
            private final GreetingService greetingService = new GreetingService(greetingRepository);
            private final IRestaurantService restaurantService=new RestaurantService(userReposiory, restaurantReposiotry,reviewReposiotry);

            // Initialize commands
            private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);

            private final AddRatingCommand addRatingCommand=new AddRatingCommand(restaurantService);
            private final DescribeRestaurantCommand describeRestaurantCommand=new DescribeRestaurantCommand(restaurantService);
            private final GetReviewFileterOrderCommand getReviewFileterOrderCommand=new GetReviewFileterOrderCommand(restaurantService);
            private final GetReviewsCommand getReviewsCommand=new GetReviewsCommand(restaurantService);
            private final ListRestaurantCommand listRestaurantCommand=new ListRestaurantCommand(restaurantService);
            private final RegisterRestaurantCommand registerRestaurantCommand=new RegisterRestaurantCommand(restaurantService);
            private final RegisterUserCommand registerUserCommand=new RegisterUserCommand(restaurantService);

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);

                commandRegistry.registerCommand(CommandKeyword.ADD_RATING_COMMAND.getName(),addRatingCommand);
                commandRegistry.registerCommand(CommandKeyword.DESCRIBE_RESTAURANT_COMMAND.getName(),describeRestaurantCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_REVIEWS_COMMAND.getName(),getReviewsCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_REVIEWS_FILTER_ORDER_COMMAND.getName(),getReviewFileterOrderCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_RESTAURANT_COMMAND.getName(),listRestaurantCommand);
                commandRegistry.registerCommand(CommandKeyword.REGISTER_RESTAURANT_COMMAND.getName(),registerRestaurantCommand);
                commandRegistry.registerCommand(CommandKeyword.REGISTER_USER_COMMAND.getName(),registerUserCommand);


            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
