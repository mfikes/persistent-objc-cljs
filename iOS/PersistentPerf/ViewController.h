//
//  ViewController.h
//  PersistentPerf
//
//  Created by Mike Fikes on 11/12/14.
//
//

#import "GBYViewController.h"

@interface ViewController : GBYViewController

@property (weak, nonatomic) IBOutlet UILabel *objCTimeLabel;
@property (weak, nonatomic) IBOutlet UILabel *cljsTimeLabel;

@end

