//
//  ViewController.h
//  PersistentPerf
//
//  Created by Mike Fikes on 11/12/14.
//
//

#import "GBYViewController.h"

@protocol ViewController <JSExport>

-(void)runTests;
-(double)currentTime;

@end

@interface ViewController : GBYViewController<ViewController>

@property (weak, nonatomic) IBOutlet UILabel *objCTimeLabel;
@property (weak, nonatomic) IBOutlet UILabel *cljsTimeLabel;
@property (weak, nonatomic) IBOutlet UIButton *runTestsButton;

@end

