1. I added additional delay for network request to check scenario when user exit from activation screen. Check
   `NetworkRepoImpl:11`
2. Maybe I understand requirements wrong but implement one way passing card
   state: `unscratched -> scratched -> activated`. So user can't skip any of stage
3. I didn't unit test cover whole of app but instead selected each of app component and showed how it could be covered 
